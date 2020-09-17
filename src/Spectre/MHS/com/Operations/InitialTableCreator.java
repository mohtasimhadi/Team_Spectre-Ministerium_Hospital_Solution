package Spectre.MHS.com.Operations;

import Spectre.MHS.com.Tools.SQLConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialTableCreator {
    public static Connection connection;
    public static Statement statement;

    public static void createDBTable(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","");

            String sql0 = "CREATE DATABASE mhs";

            String sql1 = "CREATE TABLE `admin` (\n" +
                    "  `ID` int(10) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` varchar(50),\n" +
                    "  `DateOfBirth` date,\n" +
                    "  `Address` varchar(150),\n" +
                    "  `ContactNo` int(13),\n" +
                    "  `Email` varchar(50),\n" +
                    "  `Gender` varchar(6),\n" +
                    "  `EducationQualification` varchar(20),\n" +
                    "  `Designation` varchar(100),\n" +
                    "  `BloodGroup` varchar(3),\n" +
                    "  `DateOfJoin` date,\n" +
                    "  `Password` varchar(250) NOT NULL,\n" +
                    "  CONSTRAINT admin_pk PRIMARY KEY (ID)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            String sql2 = "CREATE TABLE `doctor` (\n" +
                    "  `ID` int(10) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` varchar(50) ,\n" +
                    "  `DateOfBirth` date ,\n" +
                    "  `Address` varchar(150) ,\n" +
                    "  `ContactNo` int(13) ,\n" +
                    "  `Email` varchar(50) ,\n" +
                    "  `Gender` varchar(6) ,\n" +
                    "  `EducationQualification` varchar(20) ,\n" +
                    "  `Designation` varchar(100) ,\n" +
                    "  `BloodGroup` varchar(3) ,\n" +
                    "  `DateOfJoin` date ,\n" +
                    "  `Password` varchar(255) NOT NULL,\n" +
                    "  CONSTRAINT doctor_pk PRIMARY KEY (ID)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            String sql3 = "CREATE TABLE `pathologist` (\n" +
                    "  `ID` int(10) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` varchar(50) ,\n" +
                    "  `DateOfBirth` date ,\n" +
                    "  `Address` varchar(150) ,\n" +
                    "  `ContactNo` int(13) ,\n" +
                    "  `Email` varchar(50) ,\n" +
                    "  `Gender` varchar(6) ,\n" +
                    "  `EducationQualification` varchar(20) ,\n" +
                    "  `Designation` varchar(100) ,\n" +
                    "  `BloodGroup` varchar(3) ,\n" +
                    "  `DateOfJoin` date ,\n" +
                    "  `Password` varchar(255) NOT NULL,\n" +
                    "  CONSTRAINT pathologist_pk PRIMARY KEY (ID)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            String sql4 = "CREATE TABLE `patient` (\n" +
                    "  `ID` int(10) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` varchar(50) ,\n" +
                    "  `Age` int(3) ,\n" +
                    "  `Gender` varchar(6) ,\n" +
                    "  `DateOfAdmission` date ,\n" +
                    "  `DateOfAppointment` date ,\n" +
                    "  `AppointedDoctor` int(10) ,\n" +
                    "  `DateOfRelease` date ,\n" +
                    "  `ContactNo` int(13) ,\n" +
                    "  `Email` varchar(50) ,\n" +
                    "  `BloodGroup` varchar(3) ,\n" +
                    "  `Prescription` varchar(500) ,\n" +
                    "  `PathologyTests` varchar(300) ,\n" +
                    "  CONSTRAINT patient_pk PRIMARY KEY (ID),\n" +
                    "CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`AppointedDoctor`) REFERENCES `doctor` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";

            String sql5 =
                    "CREATE TABLE `receptionist` (\n" +
                    "  `ID` int(10) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` varchar(50) ,\n" +
                    "  `DateOfBirth` date ,\n" +
                    "  `Address` varchar(150) ,\n" +
                    "  `ContactNo` int(13) ,\n" +
                    "  `Email` varchar(50) ,\n" +
                    "  `Gender` varchar(6) ,\n" +
                    "  `EducationQualification` varchar(20) ,\n" +
                    "  `Designation` varchar(100) ,\n" +
                    "  `BloodGroup` varchar(3) ,\n" +
                    "  `DateOfJoin` date ,\n" +
                    "  `Password` varchar(255) NOT NULL,\n" +
                    "  CONSTRAINT doctor_pk PRIMARY KEY (ID)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n";

            String sql6 = "ALTER TABLE `patient`\n" +
                    "  ADD KEY `AppointedDoctor` (`AppointedDoctor`);";

            String sql7 = "INSERT INTO `admin` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('1000', 'admin', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Human Resource Management Admin', 'z+', '2000-01-01', '80f5414f8bda805dd0484569dc7be9573807c65f');";

            String sql8 = "INSERT INTO `doctor` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('2000', 'a', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Doctor', 'z+', '2000-01-01', 'a');";

            String sql9 = "INSERT INTO `receptionist` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('3000', 'a', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Receptionist', 'z+', '2000-01-01', 'a');";

            String sql10 = "INSERT INTO `pathologist` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('4000', 'a', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Pathologist', 'z+', '2000-01-01', 'a');";

            String sql11 = "INSERT INTO `patient` (`ID`, `Name`, `Age`, `Gender`, `DateOfAdmission`, `DateOfAppointment`, `AppointedDoctor`, `DateOfRelease`, `ContactNo`, `Email`, `BloodGroup`, `Prescription`, `PathologyTests`) \n" +
                    "VALUES ('10000', 'a', '1', 'b', '2000-01-01', '2000-01-01', '2000', '2000-01-01', '0000000000000', 'c@d.com', 'e+', 'ffffff', 'ggggggggg');";

            statement = connection.createStatement();
            statement.executeUpdate(sql0);
            SQLConnector sqlConnector = new SQLConnector();
            sqlConnector.executeUpdate(sql1);
            sqlConnector.executeUpdate(sql2);
            sqlConnector.executeUpdate(sql3);
            sqlConnector.executeUpdate(sql4);
            sqlConnector.executeUpdate(sql5);
            sqlConnector.executeUpdate(sql6);
            sqlConnector.executeUpdate(sql7);
            sqlConnector.executeUpdate(sql8);
            sqlConnector.executeUpdate(sql9);
            sqlConnector.executeUpdate(sql10);
            sqlConnector.executeUpdate(sql11);

            JOptionPane.showMessageDialog(null, "Database Created");

        }
        catch (SQLException e) {
            e.printStackTrace();
            String exception = e.toString();
            if (exception.equals("java.sql.SQLException: Can't create database 'mhs'; database exists"))
                JOptionPane.showMessageDialog(null, "Database Already Exists");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

