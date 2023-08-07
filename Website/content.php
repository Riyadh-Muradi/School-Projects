<?php
class card {
    public $id;
    public $teksti;

    // Funktiot
    function set_id($id) {
        $this->id = $id;
    }
    function get_id() {
        return $this->id;
    }


    function set_Teksti($teksti) {
        $this->teksti = $teksti;
    }
    function get_Teksti() {
        return $this->teksti;
    }

}
$lista = array();

$kortti = new card();
$kortti->set_id("etusivu 0");
$kortti->set_Teksti(
    '<h1>Otsikko 1 </h1>
    <p>Teksti</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("etusivu 1");
$kortti->set_Teksti(
    '<h1>Otsikko 2 </h1>
    <p>Teksti 2</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("etusivu 2");
$kortti->set_Teksti(
    '<h1>Otsikko 3 </h1>
    <p>Teksti 3</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("koulu 0");
$kortti->set_Teksti(
    '<h1>Otsikko 1 </h1>
    <p>Teksti 1</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("koulu 1");
$kortti->set_Teksti(
    '<h1>Otsikko 2 </h1>
    <p>Teksti 2</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("koulu 2");
$kortti->set_Teksti(
    '<h1>Otsikko 3 </h1>
    <p>Teksti 3</p>
    '
    );
array_push($lista,$kortti);


$kortti = new card();
$kortti->set_id("esittely 0");
$kortti->set_Teksti(
    '<h1>Otsikko 1 </h1>
    <p>Teksti 1</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("esittely 1");
$kortti->set_Teksti(
    '<h1>Otsikko 2 </h1>
    <p>Teksti 2</p>
    '
    );
array_push($lista,$kortti);

$kortti = new card();
$kortti->set_id("esittely 2");
$kortti->set_Teksti(
    '<h1>Otsikko 3 </h1>
    <p>Teksti 3</p>
    '
    );
array_push($lista,$kortti);
?>