package Spectre.MHS.com.OperationsNTools;

import java.sql.SQLException;

public class InitialTableCreator {
    public static void createDBTable(){
        SQLConnector sqlConnector = new SQLConnector();

        try {

            String sql = "SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";\n" +
                    "SET AUTOCOMMIT = 0;\n" +
                    "START TRANSACTION;\n" +
                    "SET time_zone = \"+00:00\";\n" +
                    "\n" +
                    "CREATE TABLE `admin` (\n" +
                    "  `ID` int(10) NOT NULL,\n" +
                    "  `Name` varchar(50) NOT NULL,\n" +
                    "  `DateOfBirth` date NOT NULL,\n" +
                    "  `Address` varchar(150) NOT NULL,\n" +
                    "  `ContactNo` int(13) NOT NULL,\n" +
                    "  `Email` varchar(50) NOT NULL,\n" +
                    "  `Gender` varchar(6) NOT NULL,\n" +
                    "  `EducationQualification` varchar(20) NOT NULL,\n" +
                    "  `Designation` varchar(100) NOT NULL,\n" +
                    "  `BloodGroup` varchar(3) NOT NULL,\n" +
                    "  `DateOfJoin` date NOT NULL,\n" +
                    "  `Password` varchar(250) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n" +
                    "\uFEFF\n" +
                    "CREATE TABLE `doctor` (\n" +
                    "  `ID` int(10) NOT NULL,\n" +
                    "  `Name` varchar(50) NOT NULL,\n" +
                    "  `DateOfBirth` date NOT NULL,\n" +
                    "  `Address` varchar(150) NOT NULL,\n" +
                    "  `ContactNo` int(13) NOT NULL,\n" +
                    "  `Email` varchar(50) NOT NULL,\n" +
                    "  `Gender` varchar(6) NOT NULL,\n" +
                    "  `EducationQualification` varchar(20) NOT NULL,\n" +
                    "  `Designation` varchar(100) NOT NULL,\n" +
                    "  `BloodGroup` varchar(3) NOT NULL,\n" +
                    "  `DateOfJoin` date NOT NULL,\n" +
                    "  `Password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n" +
                    "\n" +
                    "CREATE TABLE `pathologist` (\n" +
                    "  `ID` int(10) NOT NULL,\n" +
                    "  `Name` varchar(50) NOT NULL,\n" +
                    "  `DateOfBirth` date NOT NULL,\n" +
                    "  `Address` varchar(150) NOT NULL,\n" +
                    "  `ContactNo` int(13) NOT NULL,\n" +
                    "  `Email` varchar(50) NOT NULL,\n" +
                    "  `Gender` varchar(6) NOT NULL,\n" +
                    "  `EducationQualification` varchar(20) NOT NULL,\n" +
                    "  `Designation` varchar(100) NOT NULL,\n" +
                    "  `BloodGroup` varchar(3) NOT NULL,\n" +
                    "  `DateOfJoin` date NOT NULL,\n" +
                    "  `Password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n" +
                    "\n" +
                    "CREATE TABLE `patient` (\n" +
                    "  `ID` int(10) NOT NULL,\n" +
                    "  `Name` varchar(50) NOT NULL,\n" +
                    "  `Age` int(3) NOT NULL,\n" +
                    "  `Gender` varchar(6) NOT NULL,\n" +
                    "  `DateOfAdmission` date NOT NULL,\n" +
                    "  `DateOfAppointment` date NOT NULL,\n" +
                    "  `AppointedDoctor` int(10) NOT NULL,\n" +
                    "  `DateOfRelease` date NOT NULL,\n" +
                    "  `ContactNo` int(13) NOT NULL,\n" +
                    "  `Email` varchar(50) NOT NULL,\n" +
                    "  `BloodGroup` varchar(3) NOT NULL,\n" +
                    "  `Prescription` varchar(500) NOT NULL,\n" +
                    "  `PathologyTests` varchar(300) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n" +
                    "\uFEFF\n" +
                    "CREATE TABLE `receptionist` (\n" +
                    "  `ID` int(10) NOT NULL,\n" +
                    "  `Name` varchar(50) NOT NULL,\n" +
                    "  `DateOfBirth` date NOT NULL,\n" +
                    "  `Address` varchar(150) NOT NULL,\n" +
                    "  `ContactNo` int(13) NOT NULL,\n" +
                    "  `Email` varchar(50) NOT NULL,\n" +
                    "  `Gender` varchar(6) NOT NULL,\n" +
                    "  `EducationQualification` varchar(20) NOT NULL,\n" +
                    "  `Designation` varchar(100) NOT NULL,\n" +
                    "  `BloodGroup` varchar(3) NOT NULL,\n" +
                    "  `DateOfJoin` date NOT NULL,\n" +
                    "  `Password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n" +
                    "\uFEFF\n" +
                    "ALTER TABLE `admin`\n" +
                    "  ADD PRIMARY KEY (`ID`);\n" +
                    "\n" +
                    "ALTER TABLE `doctor`\n" +
                    "  ADD PRIMARY KEY (`ID`);\n" +
                    "\n" +
                    "ALTER TABLE `pathologist`\n" +
                    "  ADD PRIMARY KEY (`ID`);\n" +
                    "\n" +
                    "ALTER TABLE `patient`\n" +
                    "  ADD PRIMARY KEY (`ID`),\n" +
                    "  ADD KEY `AppointedDoctor` (`AppointedDoctor`);\n" +
                    "\n" +
                    "ALTER TABLE `receptionist`\n" +
                    "  ADD PRIMARY KEY (`ID`);\n" +
                    "\uFEFF\n" +
                    "ALTER TABLE `admin`\n" +
                    "  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;\n" +
                    "\n" +
                    "ALTER TABLE `doctor`\n" +
                    "  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;\n" +
                    "\n" +
                    "ALTER TABLE `pathologist`\n" +
                    "  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;\n" +
                    "\n" +
                    "ALTER TABLE `patient`\n" +
                    "  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;\n" +
                    "\n" +
                    "ALTER TABLE `receptionist`\n" +
                    "  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;\n" +
                    "\uFEFF\n" +
                    "ALTER TABLE `patient`\n" +
                    "  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`AppointedDoctor`) REFERENCES `doctor` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;\n" +
                    "\uFEFFCOMMIT;\n" +
                    "\n" +
                    "INSERT INTO `admin` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('1000', 'admin', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Human Resource Management Admin', 'z+', '2000-01-01', 'admin');\n" +
                    "\n" +
                    "INSERT INTO `doctor` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('2000', 'a', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Doctor', 'z+', '2000-01-01', 'a');\n" +
                    "\n" +
                    "INSERT INTO `receptionist` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('3000', 'a', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Receptionist', 'z+', '2000-01-01', 'a');\n" +
                    "\n" +
                    "INSERT INTO `pathologist` (`ID`, `Name`, `DateOfBirth`, `Address`, `ContactNo`, `Email`, `Gender`, `EducationQualification`, `Designation`, `BloodGroup`, `DateOfJoin`, `Password`) \n" +
                    "VALUES ('4000', 'a', '2000-01-01', 'a', '0000000000000', 'a@b.com', 'cccccc', 'ddd', 'Pathologist', 'z+', '2000-01-01', 'a');\n" +
                    "\n" +
                    "INSERT INTO `patient` (`ID`, `Name`, `Age`, `Gender`, `DateOfAdmission`, `DateOfAppointment`, `AppointedDoctor`, `DateOfRelease`, `ContactNo`, `Email`, `BloodGroup`, `Prescription`, `PathologyTests`) \n" +
                    "VALUES ('10000', 'a', '1', 'b', '2000-01-01', '2000-01-01', '2000', '2000-01-01', '0000000000000', 'c@d.com', 'e+', 'ffffff', 'ggggggggg');";

            sqlConnector.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

