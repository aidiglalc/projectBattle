import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

// This class manages all the methods that have a connection with SQL

class DatabaseConnection {

    // With this method you input a race that exists in the database and returns an ArrayList of the characters of that race

    public ArrayList<Character> getRace(String race) {
        ArrayList<Character> characters = new ArrayList<Character>();
        String query = "SELECT warriors.warrior_id, warriors.warrior_name, warriors.warrior_image_path, warriors.warrior_lore, race.race, race.hp, race.strength,\n" +
                "race.defense, race.agility, race.speed, race.race_points FROM warriors INNER JOIN race ON warriors.warrior_race = race.race_id " +
                "WHERE race.race = \"" + race + "\";";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                if (race.equalsIgnoreCase("Human")) {
                    characters.add(new Human(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
                            rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8), rs.getInt(9),
                            rs.getInt(10), rs.getInt(11)));
                }

                else if (race.equalsIgnoreCase("Elf")) {
                    characters.add(new Elf(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
                            rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8), rs.getInt(9),
                            rs.getInt(10), rs.getInt(11)));
                }

                else if (race.equalsIgnoreCase("Dwarf")) {
                    characters.add(new Dwarf(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),
                            rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8), rs.getInt(9),
                            rs.getInt(10), rs.getInt(11)));
                }
            }

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
        return characters;
    }

    // This method returns an array list of weapons of the selected race, if "" is inserted as parameter, it returns all weapons

    public ArrayList<Weapon> getWeapons(String race) {
        ArrayList<Weapon> weapons = new ArrayList<Weapon>();
        String query = "SELECT * FROM weapons WHERE weapon_race LIKE \"%" + race + "%\";";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                weapons.add(new Weapon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7)));
            }

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
        return weapons;
    }

    // In this method we get an array list of the top ten players ordered by points, we get those players from the database

    public ArrayList getTopTen() {
        ArrayList topTen = new ArrayList();
        ArrayList player;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);

            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery("SELECT players.player_name, game.total_points FROM game INNER JOIN players ON game.player_id = players.player_id ORDER BY total_points DESC LIMIT 10;");

            while (rs.next()) {
                player = new ArrayList();
                player.add(rs.getString(1));
                player.add(rs.getInt(2));
                topTen.add(player);
            }

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
        return topTen;
    }

    // This method manages the confirm dialog to input the database user and password

    public void setDataBaseConection() {
        String transformConfirmDialog;
        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        int option;

        option = JOptionPane.showConfirmDialog(null, textField, "Database User", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.CANCEL_OPTION) {
            System.exit(1);
        }

        Data.dataBaseUser = textField.getText();

        option = JOptionPane.showConfirmDialog(null, passwordField, "Database Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.CANCEL_OPTION) {
            System.exit(1);
        }

        transformConfirmDialog = new String(passwordField.getPassword());
        Data.dataBasePassword = transformConfirmDialog;
    }

    // This method inserts the player to the database, if it's the last record it doesn't insert

    public void insertPlayerDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);

            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT player_name FROM players WHERE player_id = (SELECT MAX(player_id) FROM players);");
            rs.next();

            if (!rs.getString(1).equalsIgnoreCase(Data.playerName)){
                stm.executeUpdate("INSERT INTO players (player_name) VALUES(\"" + Data.playerName + "\");");
            }

            rs = stm.executeQuery("SELECT player_id FROM players WHERE player_id = (SELECT MAX(player_id) FROM players);");
            rs.next();

            Data.playerId = rs.getInt(1);

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // This method inserts a new game to the database

    public void insertGameDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);

            Statement stm = con.createStatement();
            stm.executeUpdate("INSERT INTO game (player_id, warrior_id, warrior_weapon_id, total_points, enemies_defeated) " +
                    "VALUES (" + Data.playerId + ", " + Data.player.getWarrior_id() + ", "+ Data.playerWeapon.getWeapon_id() + ", " + Data.points + ", " + Data.winningStreak + "); ");

            ResultSet rs = stm.executeQuery("SELECT game_id FROM game WHERE game_id = (SELECT MAX(game_id) FROM game);");
            rs.next();

            Data.gameId = rs.getInt(1);

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // This method saves the battles

    public void insertBattleDatabase() {
        int points = 0;

        if (Data.player.getCurrenthp() > 0) points = Data.enemy.getRace_points() + Data.enemyWeapon.getWeapon_points();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);

            Statement stm = con.createStatement();
            stm.executeUpdate("INSERT INTO battle (game_id, player_id, warrior_id, warrior_weapon_id, opponent_id, opponent_weapon_id, injuries_caused, injuries_suffered, battle_points)" +
                    " VALUES (" + Data.gameId + ", " + Data.playerId + ", " + Data.player.getWarrior_id() + ", " + Data.playerWeapon.getWeapon_id() +
                    ", " + Data.enemy.getWarrior_id() + ", " + Data.enemyWeapon.getWeapon_id() + ", " + (Data.enemy.getHp() - Data.enemy.getCurrenthp()) +
                    ", " + (Data.player.getHp() - Data.player.getCurrenthp()) + ", " + points +")");

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // This method updates the game info

    public void updateGameDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Data.dataBaseUrl, Data.dataBaseUser, Data.dataBasePassword);

            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery("SELECT * FROM game WHERE game_id = " + Data.gameId + ";");
            rs.next();

            rs.updateInt(5, Data.points);
            rs.updateInt(6, Data.winningStreak);
            rs.updateRow();

        } catch(SQLSyntaxErrorException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: battle_database not found in your databases.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Add the driver to connect Java with MySQL.", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Wrong User / Password for the database", "Database loading Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // With this method we get the player Name and ensure its made of letters and numbers

    public String getPlayerName() {
        String message = "Write your name:";
        String name = "";
        char chars[];
        boolean flagCharacter = false;
        int count = 0;

        while (!flagCharacter) {
            count = 0;
            name = JOptionPane.showInputDialog(null, message, "Player Name", JOptionPane.INFORMATION_MESSAGE);
            if (name != null){
                chars = name.toCharArray();
                flagCharacter = true;

                if (name.equalsIgnoreCase("")) {
                    flagCharacter = false;
                    message = "Write your name, don't let this blank:";
                }

                else {
                    for (char c : chars) {
                        count++;
                        if (!java.lang.Character.isDigit(c) && !java.lang.Character.isLetter(c)) {
                            flagCharacter = false;
                            message = "Write your name, only letters and numbers:";
                        }
                    }
                    if (count > 20) {
                        flagCharacter = false;
                        message = "Write your name, not more than 20 characters:";
                    }
                }
            }
            else {
                flagCharacter = true;
            }
        }
        return name;
    }
}
