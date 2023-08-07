
<div class="card">
	<?php 
	$Identification = $Identity . " " . $i;
    //echo("<h5>".$Identification."</h5>")
	?>
	<div class="pra">
        <?php
		for($k = 0; $k < count($lista); $k++)
        {
            if($lista[$k]->get_id() == $Identification){

                echo($lista[$k]->get_Teksti());
                break;
            }
        }
        ?>
	</div>
</div>