import React from 'react';
import { Link } from 'react-router-dom';

const MainHeader = () => {
  return (
    <nav className="h-[60px] border-b-[1px] border-slate-200">
      <div className="container mx-auto h-full">
        <div className="flex h-full items-center justify-between">
          <div className="cursor-pointer">
            <Link to="/">
              <h1 className="text-3xl font-bold">블로그</h1>
            </Link>
          </div>
          <div>
            <ul>
              <Link to="/createPost">
                <li className="cursor-pointer rounded-lg px-3 py-2 hover:bg-gray-100">글쓰기</li>
              </Link>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default MainHeader;
