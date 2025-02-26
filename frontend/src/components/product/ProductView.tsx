import { ReactNode } from "react";
import { Product } from "../../types/product";

type Props = {
  product: Product;
};

const ProductView = (props: Props) => {
  const { product } = props;

  let type: ReactNode = product.type ? <>{product.type.name}</> : <i>no type</i>;
  let colors: ReactNode = product.colors ? <>{product.colors.map(c => c.name).join(', ')}</> : <i>no colors</i>;

  return (
    <tr>
      <td>{product.id}</td>
      <td>{product.name}</td>
      <td>{type}</td>
      <td>{colors}</td>
    </tr>
  );

}

export default ProductView;
