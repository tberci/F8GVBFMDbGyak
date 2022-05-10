<Query Kind="Program" />

void Main()
{
	var guests = new []{

	new Guest(101, "Mariska", 18, new Address("Fokváros", "Kukutyin")),
	new Guest(103, "Gizi", 43, new Address("Újváros", "Kukutyin")),
	new Guest(135, "Ferenc", 56, new Address("Főváros", "Kamcsatka")),
	new Guest(400, "Aladár", 23, new Address("Óváros", "Románia")),
};

	//c)	Írjuk ki azon országokat és az onnan érkezők számát, ahonnan legalább ketten jöttek.
	//guests.Select(x => x).Dump();
	guests.GroupBy(x => x.Address.Country).Where(x => x.Count() > 1).Select(x => new{x.Key, count=x.Count()}).Dump("Task C");
	guests.First().Dump();
	
	
	
	Address [] address = {};
	
	address.FirstOrDefault().Dump();
	
	
	guests.Where(x => x.RoomId.ToString().Substring(0,2) == guests.First().RoomId.ToString().Substring(0,2)).Select(x => x.Name).Dump("Task D");
}

class Guest
{
	public int RoomId {get; set;}
	public string Name {get; set;}
	public int Age {get; set;}
	public Address Address {get; set;}
	
	public Guest(int roomId, string name, int age, Address address)
	{
		RoomId = roomId;
		Name = name;
		Age = age;
		Address = address;
	}
}

class Address
{
	public string City {get; set;}
	public string Country {get; set;}
	
	public Address(){
		this.City = "";
		this.Country ="";
	}
	
	public Address(string city, string country)
	{
		City = city;
		Country = country;
	}
}
