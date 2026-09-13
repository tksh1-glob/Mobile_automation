function generarEmailRandom() {
  const numeroRandom = Date.now(); // siempre distinto, evita choques de "usuario ya existe"
  return `usuario${numeroRandom}@test.com`;
}

module.exports = { generarEmailRandom };