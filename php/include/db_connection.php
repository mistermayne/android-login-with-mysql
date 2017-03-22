<?php
	/**
	*Database config variables
	*/
	define("DB_HOST","localhost");
	define("DB_USER","root");
	define("DB_PASSWORD","usbw");
	define("DB_DATABASE","android_login");

	$connection = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_DATABASE);

	if(mysqli_connect_errno()){
		die("Database connnection failed " . "(" .
			mysqli_connect_error() . " - " . mysqli_connect_errno() . ")"
				);
	}
?>