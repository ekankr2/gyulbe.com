import React from 'react';
import MainHeader from '../sections/MainHeader';
import Footer from '../sections/Footer';
import { Outlet } from 'react-router-dom';

const MainLayout = () => {
  return (
    <>
      <MainHeader />
      <main className="min-h-screen">
        <Outlet />
      </main>
      <Footer />
    </>
  );
};

export default MainLayout;
