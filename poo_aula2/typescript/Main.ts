import CofreDigital from "./CofreDigital.js";

const cofre = new CofreDigital();

console.log(cofre);

// Testando o Depósito
cofre.Depositar(100);
cofre.Depositar(-10);

console.log(
    "Saldo Esperado = 100 | Saldo Atual = " + cofre.Saldo()
);

const ok1 = cofre.Sacar(30);
const ok2 = cofre.Sacar(500);

console.log(
    "Saque 30 ok? " + ok1 + " | Saque 500 ok? " + ok2
);

console.log(
    "Saldo Esperado = 70 | Saldo Atual = " + cofre.Saldo()
);

