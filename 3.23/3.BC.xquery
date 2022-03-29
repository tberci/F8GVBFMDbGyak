xquery version "3.1";

let $ett := doc('F8GVBF_XML.xml')/f8gvbf
let $result :=
for $r in $ett/rendeles, $v in $ett/vendeg, $e in $ett/etterem
where $r/@fk_vkod eq $v/@vkod and $r/@fk_ekod eq $e/@ekod
return 
    <res>
        <ett>{$e}</ett>
        <vendeg>{$v}</vendeg>
        <rendeles> {$r} </rendeles>
    </res>

let $szamla :=
for $n in 1 to count($result)
let  $date := current-dateTime()
return
    <Szamla szkod="{$n}" fk_ekod="{@result[position()=$n]/ett/etterem/@ekod}" fk_vkod =  "{$result[position()=$n]/vendeg/vendeg/@vkod}">
         
           <Fizetendo-osszeg> {$result[position()=$n]/rendeles/rendeles/osszeg/text()} </Fizetendo-osszeg>
           <Dátum> {$date}</Dátum>
    </Szamla>
    
return update insert $szamla into $ett


