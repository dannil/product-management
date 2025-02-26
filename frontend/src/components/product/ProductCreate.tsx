import './ProductCreate.css';

const ProductCreate = () => {

  const addProduct = (formData) => {
    console.log(formData);
  }

  return (
    <div className="product-create">
      <form className="form" action={addProduct}>
        <div className="form-row">
          <label>Name</label>
          <input name="name"></input>
        </div>
        <div className="form-row">
          <label>Type</label>
          <input name="type"></input>
        </div>
        <div className="form-row">
          <label>Colors</label>
          <input name="colors"></input>
        </div>
        <button type="submit">Add product</button>
      </form>

    </div>
  );
};

export default ProductCreate;
