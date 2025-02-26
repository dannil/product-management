import './ProductListing.css';
import { useEffect, useState } from 'react';
import { getProducts } from '../../services/product';
import { Product } from '../../types/product';
import ProductView from './ProductView';

const ProductListing = () => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    const onLoad = async () => {
      const products = await getProducts();
      setProducts(products);
    };
    onLoad();
  }, []);

  return (
    <div className="product-listing">
      <div className="list-header">
        <div className="list-cell">ID</div>
        <div className="list-cell flex-3">Name</div>
        <div className="list-cell">Type</div>
        <div className="list-cell">Colors</div>
      </div>
      {products.map((product, index) => (
        <div key={index} className="list-row">
          <ProductView product={product} />
        </div>
      ))}
    </div>
  );
};

export default ProductListing;
