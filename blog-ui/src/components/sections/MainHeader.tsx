import React from 'react';

const MainHeader = () => {
  return (
    <nav className="h-[60px] border-b-[1px] border-slate-200">
      <div className="container mx-auto h-full">
        <div className="flex h-full items-center justify-between">
          <div className="cursor-pointer">
            <h1 className="text-3xl font-bold">
              <a href="/">블로그</a>
            </h1>
          </div>
          <div>
            <ul>
              <li className="cursor-pointer rounded-lg px-3 py-2 hover:bg-gray-100">
                <a href="/createPost">글쓰기</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default MainHeader;
