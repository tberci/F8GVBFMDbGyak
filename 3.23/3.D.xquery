xquery version "3.1";

let $ett := doc('F8GVBF_XML.xml')/f8gvbf
for $sz in $ett/Szamla[@fk_ekod eq "e2"]
return update delete $sz
