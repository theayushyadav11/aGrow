
const { ethers } = require("hardhat");

async function main() {
  try {
    // Get the deployed contract address (replace with your actual address)
    const contractAddress = "0x595c26FCBE44771683D83C3e3a677497c1eD1EF9"; // Replace with your deployed address
    const contract = await ethers.getContractAt("ProductReview", contractAddress);

    // Submit a review
    console.log("Submitting a review...");
    const productId = 1;
    const email = "example@example.com";
    const content = "This product is great!";
    const rating = 5; // Adjust the rating as needed
    await contract.submitReview(productId, email, content, rating);
    console.log("Review submitted successfully.");

    // Fetch and log the review
    console.log("Fetching review...");
    const reviewCount = await contract.getReviewCount(productId);
    console.log("Total reviews:", reviewCount.toString());
    if (reviewCount > 0) {
      const [reviewer, reviewerEmail, reviewContent, reviewRating] = await contract.getReview(productId, 0);
      console.log("Review details:");
      console.log("Reviewer:", reviewer);
      console.log("Email:", reviewerEmail);
      console.log("Content:", reviewContent);
      console.log("Rating:", reviewRating);
    } else {
      console.log("No reviews found for product ID", productId);
    }
  } catch (error) {
    console.error("Error during testing:", error);
  }
}

main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error("Error:", error);
    process.exit(1);
  });
