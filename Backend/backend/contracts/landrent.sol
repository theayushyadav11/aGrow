// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "hardhat/console.sol";

contract LandRentContract {
  address payable public owner;
  address public farmer;
  uint256 public rentAmount;
  uint256 public rentDuration; // Duration in seconds
  uint256 public rentStartTime;
  bool public isRentActive;

  event RentStarted(address indexed _farmer, uint256 _startTime);
  event RentEnded(address indexed _farmer, uint256 _endTime);

  constructor(uint256 _rentAmount, uint256 _rentDuration) {
    owner = payable(msg.sender);
    rentAmount = _rentAmount;
    rentDuration = _rentDuration;
  }

  modifier onlyOwner() {
    require(msg.sender == owner, "Only owner can call this function");
    _;
  }

  modifier onlyFarmer() {
    require(msg.sender == farmer, "Only farmer can call this function");
    _;
  }

  // Added check for initial rent payment before activating rent
  function startRent(address _farmer) external payable onlyOwner {
    require(!isRentActive, "Rent is already active");
    farmer = _farmer;
    // Ensure initial rent is paid upfront
    require(msg.value == rentAmount, "Initial rent payment required");
    rentStartTime = block.timestamp;
    isRentActive = true;
    emit RentStarted(_farmer, rentStartTime);
  }

  function endRent() external onlyOwner {
    require(isRentActive, "No active rent");
    isRentActive = false;
    emit RentEnded(farmer, block.timestamp);
    farmer = address(0); // Reset farmer address
  }

  // Only allow paying rent if rent period is not expired
  function payRent() external payable onlyFarmer {
    require(isRentActive, "No active rent");
    require(block.timestamp < rentStartTime + rentDuration, "Rent period expired");
    // Log the received amount for debugging purposes (remove for production)
    console.log("Received rent:", msg.value);
    owner.transfer(msg.value);
  }

  function getRemainingRentTime() external view returns (uint256) {
    if (isRentActive && block.timestamp < rentStartTime + rentDuration) {
      return (rentStartTime + rentDuration) - block.timestamp;
    }
    return 0;
  }
}
