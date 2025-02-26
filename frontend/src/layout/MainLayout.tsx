import './MainLayout.css';
import { Outlet } from 'react-router';
import Menu from '../components/Menu2';

const MainLayout = () => {
  return (
    <div className="main-layout">
      <div className="banner">
        <h1>Product Management</h1>
      </div>
      <div>
        <Menu />
      </div>
      <div className="content">
        <Outlet />
      </div>
    </div>
  );
}

export default MainLayout;
