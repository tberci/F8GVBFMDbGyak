xquery version "3.1";

let $ett := doc('F8GVBF_XML.xml')/f8gvbf
for $r in $ett/rendeles, $v in $ett/vendeg
where $r/@fk_vkod eq $v/@vkod and $r/@fk_ekod
group by $vndeg := $r/@fk_vkod

return 
    <Tartozas>
        <Vendeg> {$v/nev/text()}
        </Vendeg>
        <Fizetendo-osszeg> {sum($r/osszeg)} </Fizetendo-osszeg>
        </Tartozas>
        
