<?php
    class CreateConnectionDatabase{
        //properties
        private $DBName;
        private $Host;
        private $DBUser;
        private $DBPassword;
        public  $option = array (
            PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8",
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
        );
        private $dsn;
        public  $errors;
        public  $connect;

        // methods
        # constructor
        public function __construct($DBName, $Host = 'localhost', $DBUser = 'root', $DBPassword = ''){
            $this->DBName       = $DBName;
            $this->Host         = $Host;
            $this->DBUser       = $DBUser;
            $this->DBPassword   = $DBPassword;
            $this->dsn          = 'mysql:host=' . $Host . ';dbname=' . $DBName;
        }
        # open a connection to database
        public function OpenConnection(){
            $user   = $this->DBUser;
            $pass   = $this->DBPassword;
            $option = $this->options;
            $dsn    = $this->dsn;
            try {
                $this->connect = new PDO($dsn, $user, $pass, $option);
                echo 'Connect database success!';
            }
            // Catch any errors
                catch (PDOException $errors) {
                $this->errors[] = $errors->getMessage();
                exit('Opp!!! Cannot create database connection');
            }
        }
        # close a connection to database
        public function CloseConnection(){
            $this->connect = null;
        }

    }
