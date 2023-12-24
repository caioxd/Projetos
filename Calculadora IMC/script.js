const altura = document.getElementById('altura');
const peso = document.getElementById('peso');
const heightWarning = document.getElementById('heightWarning');
const weightWarning = document.getElementById('weightWarning');
const resultado = document.getElementById('resultado');

const validateData = () => {
    validateHeight();
    validateWeight();
};

const validateHeight = () => {
    const height = altura.value.trim();

    if (isNaN(height) || height <= 0) {
        heightWarning.textContent = 'Altura inválida';
    } else {
        heightWarning.textContent = '';
    }
};

const validateWeight = () => {
    const weight = peso.value.trim();

    if (isNaN(weight) || weight <= 0) {
        weightWarning.textContent = 'Peso inválido';
    } else {
        weightWarning.textContent = '';
    }
};

const calcIMC = () => {
    validateHeight();
    validateWeight();

    const height = altura.value.trim();
    const weight = peso.value.trim();

    if (!isNaN(height) && height > 0 && !isNaN(weight) && weight > 0) {
        const imc = (weight / (height * height)).toFixed(2);
        let classification = '';

        if (imc < 18.5) {
            classification = 'Abaixo do peso';
        } else if (imc < 25) {
            classification = 'Peso normal';
        } else if (imc < 30) {
            classification = 'Acima do peso';
        } else if (imc < 35) {
            classification = 'Obesidade Grau I';
        } else if (imc < 41) {
            classification = 'Obesidade Grau II';
        } else {
            classification = 'Obesidade Grau III';
        }

        resultado.innerHTML = `IMC: ${imc} (${classification})`;
    } else {
        resultado.innerHTML = 'Preencha os campos corretamente';
    }
};
