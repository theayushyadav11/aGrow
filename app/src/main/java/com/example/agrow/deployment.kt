package com.example.agrow
//
//import ProductReview
//import org.web3j.crypto.Credentials
//import org.web3j.protocol.Web3j
//import org.web3j.protocol.http.HttpService
//import org.web3j.tx.Contract
//import org.web3j.tx.gas.DefaultGasProvider
//
//class Deployment {
//    // Replace with your Infura project ID and wallet private key
//    private val infuraProjectId = "https://eth-sepolia.g.alchemy.com/v2/q1RijKvpzXtOsZrY5AQaHYjiai3CPfxb"
//    private val privateKey = "0x595c26FCBE44771683D83C3e3a677497c1eD1EF9"
//
//    // Connect to Sepolia testnet
//    private val web3j: Web3j = Web3j.build(HttpService(infuraProjectId))
//
//
//    private val bytecodeString = bytecode.bytecode
//    private val abiString = abi.abi
//    // Get user credentials from their wallet
//    private val credentials = Credentials.create(privateKey)
//
//    // Deploy the contract
//    private val contract = ProductReview.deploy(
//        web3j,
//        credentials,
//        DefaultGasProvider(),
//        abiString,
//        bytecodeString
//    ).send()
//
//    // Print the deployed contract address
//    init {
//        println("Contract deployed to: ${contract.contractAddress}")
//    }
//    fun main() {
//        Deployment()
//    }
//
//}