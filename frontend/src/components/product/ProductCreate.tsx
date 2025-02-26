import './ProductCreate.css';
import { useEffect, useState } from 'react';
import { AddProduct, Color, Type } from '../../types/product';
import { addProduct, getColors, getTypes } from '../../services/product';
import { useNavigate } from 'react-router-dom';

const ProductCreate = () => {
  const navigate = useNavigate();

  const [types, setTypes] = useState<Type[]>([]);
  const [colors, setColors] = useState<Color[]>([]);
  const [error, setError] = useState('');

  useEffect(() => {
    const onLoad = async () => {
      const [fetchedTypes, fetchedColors] = await Promise.all([getTypes(), getColors()]);
      setTypes(fetchedTypes);
      setColors(fetchedColors);
    };
    onLoad();
  }, []);

  const submitProduct = async (product: AddProduct) => {
    try {
      const result = await addProduct(product);
      if (result) {
        navigate('/');
      }
    } catch (error: unknown) {
      if (error instanceof Error) {
        setError(error.message);
      }
    }
  };

  const onSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const formData = new FormData(event.currentTarget);
    const name = formData.get('name');
    const type = formData.get('type');
    const color = formData.get('color');
    if (name && type && color) {
      const product: AddProduct = {
        name: name.toString(),
        type: Number(type.toString()),
        color: Number(color.toString())
      };
      await submitProduct(product);
    } else {
      setError('Please specify name');
    }
  };

  return (
    <div className="product-create">
      {error && <div className="error">{error}</div>}
      <form className="form" onSubmit={onSubmit}>
        <div className="form-row">
          <label>Name</label>
          <input name="name"></input>
        </div>
        <div className="form-row">
          <label>Type</label>
          <select name="type">
            {types.map(type => {
              return <option key={type.id} value={type.id}>{type.name}</option>;
            })}
          </select>
        </div>
        <div className="form-row">
          <label>Colors</label>
          <select name="color">
            {colors.map(color => {
              return <option key={color.id} value={color.id}>{color.name}</option>;
            })}
          </select>
        </div>
        <button type="submit">Add product</button>
      </form>
    </div>
  );
};

export default ProductCreate;
