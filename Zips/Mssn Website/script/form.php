<?php
$ToEmail = 'mssnlasu06@yahoo.com';
$EmailSubject = 'Site contact form';
$mailheader = "From: ".$_POST["mail"]."\r\n";
$mailheader .= "Reply-To: ".$_POST["mail"]."\r\n";
$mailheader .= "Content-type: text/html; charset=iso-8859-1\r\n";
$MESSAGE_BODY = "Subject: ".$_POST["sub"]."";
$MESSAGE_BODY .= "Email: ".$_POST["mail"]."";
mail($ToEmail, $EmailSubject, $MESSAGE_BODY, $mailheader) or die ("Failure");
?>
Your message was sent
<?php
} else {
?>
<?php
};
?>