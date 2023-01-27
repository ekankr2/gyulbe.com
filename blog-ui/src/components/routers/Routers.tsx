import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MainPage from '../pages/MainPage';
import MainLayout from '../layouts/MainLayout';
import CreatePostPage from '../pages/post/CreatePostPage';

const Routers = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route index element={<MainPage />} />
        <Route path="/createPost" element={<CreatePostPage />} />
      </Route>
    </Routes>
  );
};

export default Routers;
