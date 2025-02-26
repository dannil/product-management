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
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Colors</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <ProductView key={index} product={product} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ProductListing;
