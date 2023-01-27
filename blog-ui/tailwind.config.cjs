module.exports = {
  future: {
    removeDeprecatedGapUtilities: true,
    purgeLayersByDefault: true,
  },
  content: ['./src/**/*.{js,ts,jsx,tsx}'],
  darkMode: 'class',
  theme: {
    screens: {
      xs: '480px',
      sm: '640px',
      md: '768px',
      md2: '800px',
      lg: '1024px',
      xl: '1280px',
      '2xl': '1536px',
      '3xl': '1800px',
      '4xl': '1900px',
    },
    extend: {
      gradientColorStops: {
        greenGradient: 'from-indigo-500 to-pink-500',
      },
      colors: {
        white: '#FFFFFF',
        mainColor: '#004C7E',
        subColor: '#F5F5F5',
        newsContent: '#757575',
        txt_color: '#757575',
        txt_color2: '#959595',
        txt_sub_color: '#B6B6B6',
        headerFooterColor: '#30363A',
        red: '#EE4B2B',
        mint: '#5CFFF5',
        header: {
          blackbg: '#30363A',
          white: '#fff',
        },
      },
      fontFamily: {
        roboto: ['Roboto', 'Montserrat', 'Noto Sans KR', 'Nanum Gothic'],
        notoSansKR: ['Noto Sans KR'],
      },
      lineHeight: {
        1.2: '1.2',
        1.35: '1.35',
        1.4: '1.4',
        1.57: '1.57',
      },
      keyframes: {
        zoomIn: {
          '0%, 100%': { transform: 'scale(1)' },
          '50%': { transform: 'scale(1.2)' },
        },
        scroll: {
          '0%': { transform: 'translate3d(0, -100%, 0)' },
          '15%': { transform: 'translate3d(0, -95%, 0)' },
          '85%': { transform: 'translate3d(0, 95%, 0)' },
          '100%': { transform: 'translate3d(0, 100%, 0)' },
        },
      },
      animation: {
        zoomIn: 'zoomIn 7s linear infinite',
        scroll: 'scroll 2.4s infinite normal',
      },
      transitionDuration: {
        0: '0ms',
        1500: '1500ms',
        2000: '2000ms',
        3000: '3000ms',
        4000: '4000ms',
        5000: '5000ms',
      },
    },
  },
  variants: {},
  plugins: [require('tailwindcss'), require('precss'), require('autoprefixer'), require('@tailwindcss/line-clamp')],
};
