<?php
	$mysql = new mysqli("localhost","root","","bdtouristhelp");
	$mysql->set_charset('utf8');
	if ($mysql -> connect_error) {
		die("Failed to connect". $mysql->connect_error);

	}
?>