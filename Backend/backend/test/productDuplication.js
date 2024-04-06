
const { ethers } = require("hardhat");

async function main() {
  // Get the deployed contract address (replace with your actual address)
  const productMarketAddress = "0x595c26FCBE44771683D83C3e3a677497c1eD1EF9"; // Replace with your deployed address

  const productMarket = await ethers.getContractAt("ProductMarket", productMarketAddress);

  // Testing the contract
  await productMarket.postProduct("Corn");
  const productExists = await productMarket.productExists("Corn");
  console.log("Does Corn exist?", productExists);

  // You can continue testing other functionalities here
}

main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error(error);
    process.exit(1);
  });
