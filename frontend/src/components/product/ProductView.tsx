import { Product } from '../../types/product';

type Props = {
  product: Product;
};

const ProductView = (props: Props) => {
  const { product } = props;

  const type = product.type ? <>{product.type.name}</> : <i>no type</i>;
  const colors = product.colors ? <>{product.colors.map(c => c.name).join(', ')}</> : <i>no colors</i>;

  return (
    <>
      <div className="list-cell">{product.id}</div>
      <div className="list-cell flex-3">{product.name}</div>
      <div className="list-cell">{type}</div>
      <div className="list-cell">{colors}</div>
    </>
  );
};

export default ProductView;
