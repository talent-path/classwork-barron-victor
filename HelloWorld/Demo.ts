let boolVariable : boolean = false;

let numVariable : number = 50;

let strVariable : String = "bob";

let oldArray : String[] = ["Alice", "Bob", "Dave"];

let tupleVar : [number, String, boolean];

tupleVar = [5, "Bobby", false];

enum StreetLight {
    red,yellow, green
}

let streetLight : StreetLight = StreetLight.green;

interface student {
    name : string,
    studentId : number, 
}

class somesomething implements Partial<student> {

    name?: string;
}