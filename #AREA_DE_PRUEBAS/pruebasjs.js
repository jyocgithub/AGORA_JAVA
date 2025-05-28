// // let unCoche = new Coche();
// //
// // function Coche() {
// //     // Propiedades
// //     this.marca = "Audi A6";
// //     this.combustible = "diesel";
// //     this.cantidad = 0; // Cantidad de combustible en el depósito
// // }
// //
// // let cocheMartin = new Coche();
// // let cocheSilvia = new Coche();
//
// function Coche(marca, combustible) {
//     // Propiedades
//     this.marca = marca;
//     this.combustible = combustible;
//     this.cantidad = 0; // Cantidad de combustible en el depósito.
// }
//
// let cocheMartin = new Coche("Volkswagen Golf", "gasolina");
// let cocheSilvia = new Coche("Mercedes SLK", "diesel");
//
// // consultamos los valores de ambos coches
// console.log("El coche de Martin es un: " + cocheMartin.marca + " a " + cocheMartin.combustible);
// console.log("El coche de Silvia es un: " + cocheSilvia.marca + " a " + cocheSilvia.combustible);
//
// // modificamos la marca y el combustible del coche de Martin:
// cocheMartin.marca = "BMW X5";
// cocheMartin.combustible = "diesel";
// console.log("El coche de Martin es un: " + cocheMartin.marca + " a " + cocheDeMartin.combustible);
//
// function rellenarDeposito(litros) {
//     this.cantidad = litros;     // Modificamos el valor de la propiedad cantidad de combustible
// }
//
class Coche {

    combustible = "gasolina";

    constructor(marca, nombre) {
        this._marca = nombre;
        this._nombre = nombre;
        this._deposito = 0;
    }

    // Métodos
    rellenarDeposito = function (litros) {
        this._deposito = this._deposito + litros;
    };

    // getters y setters
    get nombre() {
        return this._nombre;
    }

    set nombre(nombre) {
        this._nombre = nombre;
    }

    get marca() {
        return this._marca;
    }

    set marca(marca) {
        this._marca = marca;
    }

}


var c = new Coche("opel", "vectra");
console.log(c.marca);

c.nombre = "astra"
console.log(c.nombre);

c.rellenarDeposito(100);
console.log(c._deposito);
console.log(c.combustible);
c.combustible = "gasoil";
console.log(c.combustible);


function mediaDeTres(a, b, c) {
    let suma = a + b + c;
    let resultado = suma / 3;
    return resultado;
}

var s = mediaDeTres(3, 4, 5);
console.log(s);

var nuevaMediaDeTres = (a, b, c) => {
    let suma = a + b + c;
    let resultado = suma / 3;
    return resultado;
}
var s = nuevaMediaDeTres(3, 4, 5);
console.log(s);

function azarDe1a100() {
    return Math.floor(Math.random() * 100) + 1;
}

var a = azarDe1a100();
console.log(a);

var nuevoAzarDe1a100 = () => Math.floor(Math.random() * 100) + 1;

var a = nuevoAzarDe1a100();
console.log(a);


// CONVERSION de un string json a un objeto
const stringinicial = '{ "nombre": "Paco", "edad": 29 }';
const obj = JSON.parse(stringinicial);

console.log(obj.nombre); // 'Paco'
console.log(obj.edad); // 29

// CONVERSION de un objeto a un string json
const objeto = {
    nombre: "Pepe",
    life: 21,
    saludar: function () {
        return "Hola!";
    }
};
let stringJSONobtenido = JSON.stringify(obj);
console.log(stringJSONobtenido); // {"nombre":"Paco","edad":29}


var persona = {usuario: "Jose", apodo: "Pepe", edad: 50, jubilado: false, "hobby":["fútbol", "lectura", "natación"]};














