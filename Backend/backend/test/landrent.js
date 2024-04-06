const { ethers } = require("hardhat");

async function main() {
  // Get the deployed contract address (replace with your actual address)
  const landRentContractAddress = "0x595c26FCBE44771683D83C3e3a677497c1eD1EF9"; // Replace with your deployed address
  const landRentContract = await ethers.getContractAt("LandRentContract", landRentContractAddress);

  // Get signers
  const [owner, farmer] = await ethers.getSigners();

  // Test the contract
  console.log("Starting rent...");
  await landRentContract.connect(owner).startRent(farmer.address);

  console.log("Farmer paying rent...");
  await landRentContract.connect(farmer).payRent({ value: 100 });

  console.log("Ending rent...");
  await landRentContract.connect(owner).endRent();

  console.log("Rent duration remaining (in seconds):", await landRentContract.getRemainingRentTime());
}

main()
  .then(() => process.exit(0))
  .catch(error => {
    console.error(error);
    process.exit(1);
  });
