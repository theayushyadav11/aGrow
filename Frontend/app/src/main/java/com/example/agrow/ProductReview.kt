import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.tx.gas.DefaultGasProvider

data class Review(
    val reviewer: String,
    val email: String,
    val productId: Int,
    val content: String
)

class ProductReview(
    web3j: Web3j,
    credentials: Credentials,
    defaultGasProvider: DefaultGasProvider,
    abiString: Any,
    bytecodeString: Any
) {
    private val hasReviewed = mutableMapOf<Int, MutableMap<String, Boolean>>()
    private val reviews = mutableMapOf<Int, MutableList<Review>>()

    fun submitReview(productId: Int, email: String, content: String) {
        require(!hasReviewed[productId]?.get(email)!! ?: false) { "You have already reviewed this product with this email." }

        val newReview = Review(
            reviewer = "msg.sender",
            email = email,
            productId = productId,
            content = content
        )
        reviews.getOrPut(productId) { mutableListOf() }.add(newReview)
        hasReviewed.getOrPut(productId) { mutableMapOf() }[email] = true

        println("Review submitted by msg.sender, email: $email, productId: $productId, content: $content")
    }

    fun getReview(productId: Int, index: Int): Review? {
        return reviews[productId]?.getOrNull(index)
    }

    fun getReviewCount(productId: Int): Int {
        return reviews[productId]?.size ?: 0
    }
}