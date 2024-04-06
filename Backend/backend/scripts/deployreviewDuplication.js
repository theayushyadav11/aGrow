const { ethers } = require("hardhat");

async function main() {
  try {
    const [deployer] = await ethers.getSigners();

    // Compile the contract
    const Contract = await ethers.getContractFactory("ProductReview");

    // Deploy the contract
    console.log("Deploying ProductReview contract...");
    const contract = await Contract.deploy();

    if (!contract) {
      throw new Error("Contract deployment failed. Contract instance is undefined.");
    }

    console.log("ProductReview contract deployed to:", contract.address);
  } catch (error) {
    console.error("Error during deployment:", error);
  }
}

main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error("Error:", error);
    process.exit(1);
  });
