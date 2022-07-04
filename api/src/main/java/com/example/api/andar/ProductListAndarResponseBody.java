package com.example.api.andar;

import com.example.api.vo.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.*;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@NoArgsConstructor
class ProductListAndarResponseBody {

    @JsonProperty("pList")
    private List<Item> pList;

    static ProductListAndarResponseBody of() {
        return ProductListAndarResponseBody.of(new ArrayList<>());
    }

    ProductIdToProduct toProductIdToItem() {
        Map<ProductId, Product> productIdItemMapNew = pList.stream()
            .collect(Collectors.toMap(Item::getId, Function.identity()));
        return ProductIdToProduct.of(productIdItemMapNew);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    static class Item implements Product {

        @JsonProperty("product_no")
        private ProductId id;

        private boolean isGift;

        void setProductId(int productId) {
            this.id = AndarProductId.of(productId);
        }

    }

    public static Product toProduct(ProductDetailAndarResponseBody productDetailAndarResponseBody, DateVO dateVO) {
        ProductDetailAndarResponseBody.ProductDetail productDetail = productDetailAndarResponseBody.getProductDetail();
        return ProductImpl.builder()
                .productId(productDetail.getProductId())
                .productName(productDetail.getProductName())
//        .urls(productDetail.getProductId())
                .mainImage(productDetail.getMainImage())
                .price(productDetail.getPrice())
                .variablePrices(VariablePrices.of(RegisteredPrice.of(productDetail.getSalesPrice(), dateVO)))
                .salesPrice(productDetail.getSalesPrice())
                .variableSalesPrices(VariableSalesPrices.of(RegisteredPrice.of(productDetail.getSalesPrice(), dateVO)))
//        .discountPrice()
//        .relatedProducts()
                .promotionPeriod(productDetail.getPromotionPeriod())
                .build();
    }

}
