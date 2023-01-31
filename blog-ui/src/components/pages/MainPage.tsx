import React from 'react';
import { useGetPostList } from '../../api/hooks/postHooks';

const MainPage = () => {
  const { data } = useGetPostList({});

  console.log(data);

  return <div>메인페이지입니다.</div>;
};

export default MainPage;
