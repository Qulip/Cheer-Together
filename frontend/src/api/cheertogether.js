const HOST = 'https://i7b204.p.ssafy.io/cheertogether/'

const MEMBERS = 'members/'
const GAMES = 'games/'
const ROOMS = 'rooms/'

export default {
  members: {
    emailAuth: () => HOST + MEMBERS + 'authenticate/email', // 이메일 인증
    emailDoubleCheck: () => HOST + MEMBERS + 'validate/duplicated', // 이메일 중복 확인
    signUp: () => HOST + MEMBERS + 'join', // 회원가입
    login: () => HOST + MEMBERS + 'login', // 로그인
    findPassword: () => HOST + MEMBERS + 'find/password' // 비밀번호 찾기
  },
  league: {
    leaguesAll: () => HOST + 'leagues', // 모든 리그 정보 조회

  },
  games: {
    scheduleList: () => HOST + GAMES // 전체 스케줄 받아오기
  },
  rooms: {
    loadRooms: () => HOST + ROOMS // 생성된 응원방 받아오기
  }
}
