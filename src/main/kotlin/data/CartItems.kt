package data

// 프로젝트 전역에서 상품 데이터를 저장하는 클래스
// 항상 같은 값이 유지되어야 함: 싱글톤!
object CartItems {
    // 수정불가
    private val mutableProduct = mutableMapOf<Product, Int>()
    // read-only
    val products: Map<Product, Int> = mutableProduct

    fun addProduct(product: Product) {
        // 기존 상품이 있는 경우 수량 + 1
        mutableProduct[product]?.let {
            mutableProduct[product] = it + 1
        } ?: run {
            // 처음 상품은 수량 1
            mutableProduct[product] = 1
        }

    }
}