<?php

function formatAmount($a)
{
	return number_format($a, 2, ',', ' ');
}

$rate_dollar_to_euro = 0.76;
$rate_euro_to_dollar = 1.31;

$message = "%s %s valent %s %s";
$amount = $_GET['amount'];

if ($_GET['conversion'] == "euro_to_dollar")
	echo sprintf($message, formatAmount($amount), "euros", formatAmount($amount * $rate_euro_to_dollar), "dollars");
else
	echo sprintf($message, formatAmount($amount), "dollars", formatAmount($amount * $rate_dollar_to_euro), "euros");


?>