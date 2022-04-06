<?php
    $id = $_GET['id'];
    $json = json_decode(file_get_contents("https://api.npoint.io/73ac8b710dc31fc05950", false));
    echo json_encode($json[$id]);
?>