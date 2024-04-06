// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ProductReview {
    struct Review {
        address reviewer;
        string email;
        uint256 productId;
        string content;
        uint8 rating; // New field for rating
    }

    mapping(uint256 => mapping(string => bool)) public hasReviewed;
    mapping(uint256 => Review[]) public reviews;

    event ReviewSubmitted(address indexed reviewer, string indexed email, uint256 indexed productId, string content, uint8 rating); // Modified event with rating

    function submitReview(uint256 _productId, string memory _email, string memory _content, uint8 _rating) external {
        require(!hasReviewed[_productId][_email], "You have already reviewed this product with this email.");

        Review memory newReview = Review({
            reviewer: msg.sender,
            email: _email,
            productId: _productId,
            content: _content,
            rating: _rating // Assigning rating
        });
        reviews[_productId].push(newReview);
        hasReviewed[_productId][_email] = true;
        
        emit ReviewSubmitted(msg.sender, _email, _productId, _content, _rating); // Emitting event with rating
    }

    function getReview(uint256 _productId, uint256 _index) external view returns (
        address reviewer,
        string memory email,
        string memory content,
        uint8 rating // Including rating in return values
    ) {
        require(_index < reviews[_productId].length, "Index out of bounds");
        Review storage review = reviews[_productId][_index];
        return (review.reviewer, review.email, review.content, review.rating); // Returning rating
    }

    function getReviewCount(uint256 _productId) external view returns (uint256) {
        return reviews[_productId].length;
    }
}
