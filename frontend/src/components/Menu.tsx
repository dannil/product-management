import './Menu.css';
import { Link } from 'react-router-dom';

function Menu() {
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">View products</Link>
        </li>
        <li>
          <Link to="/new">Create product</Link>
        </li>
      </ul>
    </nav>
  );
}

export default Menu;
