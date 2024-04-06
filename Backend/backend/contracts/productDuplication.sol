// SPDX-License-Identifier: MIT 
pragma solidity ^0.8.0;

contract ProductMarket {
    address public owner;
    mapping(string => bool) public productExists;

    event ProductPosted(address indexed farmer, string productName);

    constructor() {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only contract owner can perform this action");
        _;
    }

    function postProduct(string memory productName) public {
        require(!productExists[productName], "Product already exists");

        productExists[productName] = true;
        emit ProductPosted(msg.sender, productName);
    }

    function setOwner(address newOwner) public onlyOwner {
        owner = newOwner;
    }
}
