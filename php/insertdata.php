<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
	$con=mysqli_connect("127.0.0.1","root","1208","insertdata");
	$name=$_POST['name'];
	$email=$_POST['email'];


	$sql="INSERT INTO user(name, email) VALUES ('".$name."','".$email."')";
		if(mysqli_query($con,$sql)){
			echo("Yes");
		}else{
			echo("No");
		}

	}
?>