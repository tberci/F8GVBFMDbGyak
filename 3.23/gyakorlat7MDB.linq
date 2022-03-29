<Query Kind="Statements" />

string[] nevek = {"Toronya Bertalan", "Német Viktor", "Bolyki Balázs", "Polonkai Dávid", "Marcell", "Fazekas Levente", "Vadon Enikő"};

nevek.Select(x => x).Take(3).Dump();

nevek.Select(x => x).OrderByDescending(x => x).Dump();

nevek.Where(x => x.Contains("L") || x.Contains("l")).Count().Dump();

//2.feladat

int[] numbers ={0,1,2,3,4,5,6,7,8,9,10};

numbers.Where(x => x%2 == 0).Select(x => x*x).Dump("B");
int nums = numbers.Count().Dump();

double avg = numbers.Average().Dump("C");

numbers.Where(x => x > avg).Dump();
numbers.Where(x => x > avg).Select(x => new {x, Diff= Math.Abs(x-avg)}).Dump("D");




