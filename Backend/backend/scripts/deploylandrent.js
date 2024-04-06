const { ethers } = require("hardhat");

async function main() {
  // Deploy the contract
  const LandRentContract = await ethers.getContractFactory("LandRentContract");
  const landRentContract = await LandRentContract.deploy(100, 3600);
  console.log("LandRentContract deployed to:", landRentContract.address);
}

main()
  .then(() => process.exit(0))
  .catch(error => {
    console.error(error);
    process.exit(1);
  });
