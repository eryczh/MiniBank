fun main() {
    println("Bem-Vindo ao MiniBank!")
    pulaLinha()

    val contaDoEric = Conta(titular = "Eric", numero = 1)
    contaDoEric.deposita(valor = 236.00)
    println("titular da conta = " + contaDoEric.titular)
    println("número da conta = " + contaDoEric.numero)
    println("saldo da conta = " + contaDoEric.saldo)

    pulaLinha()

    val contaDaFran = Conta(titular = "Fran", numero = 2)
    contaDaFran.deposita(valor = 123.43)
    println("titular da conta = ${contaDaFran.titular}")
    println("número da conta = ${contaDaFran.numero}")
    println("saldo da conta = ${contaDaFran.saldo}")

    pulaLinha()

    println("Depositando na conta do Eric")
    contaDoEric.deposita(valor = 50.00)
    println("Saldo atualizado = ${contaDoEric.saldo}")

    pulaLinha()

    println("Depositando na conta da Fran")
    contaDaFran.deposita(valor = 70.0)
    println("Saldo atualizado = ${contaDaFran.saldo}")

    pulaLinha()

    println("Sacando na conta do Eric")
    contaDoEric.saca(valor = 80.0)
    println("Saldo atualizado = ${contaDoEric.saldo}")

    pulaLinha()

    println("Sacando na conta da Fran")
    contaDaFran.saca(valor = 100.0)
    println("Saldo atualizado = ${contaDaFran.saldo}")

    pulaLinha()

    println("Transferência da conta do Eric para a Fran")

    if (contaDoEric.trasfere(destino = contaDaFran, valor = 100.0)) {
        println("Transferência bem-sucedida")
    } else {
        println("Falha na transferência")
    }

    pulaLinha()

    println("Saldo atualizado = ${contaDoEric.saldo}")
    println("Saldo atualizado = ${contaDaFran.saldo}")

}

class Conta(var titular: String, val numero: Int) {

    var saldo: Double = 0.0
        private set


    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            saldo -= valor
        }
    }

    fun trasfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false

    }

}

fun pulaLinha() {
    println()
}



