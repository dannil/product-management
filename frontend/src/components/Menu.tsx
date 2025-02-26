import './Menu.css';

function Menu() {
  return (
    <nav>
      <ul>
        <li>
          <a href="/product">View products</a>
        </li>
        <li>
          <a href="/product/new">Create product</a>
        </li>
      </ul>

    </nav>
  );
}

export default Menu;
