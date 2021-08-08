delimiter $$

CREATE DATABASE `anshika` /*!40100 DEFAULT CHARACTER SET utf8 */$$


delimiter $$

CREATE TABLE `admin` (
  `AdminId` int(11) NOT NULL,
  `AdminName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`AdminId`,`Password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


delimiter $$

CREATE TABLE `information` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(60) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Balance` double NOT NULL,
  `Password` varchar(45) NOT NULL,
  `AdminID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


delimiter $$

CREATE TABLE `transactions` (
  `TID` int(11) NOT NULL,
  `TDate` date DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `Deposit` double DEFAULT NULL,
  `Withdrawl` double DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$


