package com.ssafy.cheertogether.room.service;

import static com.ssafy.cheertogether.room.RoomConstant.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.cheertogether.room.domain.Room;
import com.ssafy.cheertogether.room.dto.RoomCreateRequest;
import com.ssafy.cheertogether.room.dto.RoomModifyRequest;
import com.ssafy.cheertogether.room.dto.RoomResponse;
import com.ssafy.cheertogether.room.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

	private final RoomRepository roomRepository;

	@Transactional(readOnly = true)
	public List<RoomResponse> findRooms() {
		List<Room> roomList = roomRepository.findAll();
		return roomList.stream().map(RoomResponse::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public RoomResponse findRoomById(Long id) {
		Room room = roomRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(MISMATCH_ROOM_ID_ERROR_MESSAGE));
		return new RoomResponse(room);
	}

	@Transactional(readOnly = true)
	public RoomResponse findRoomByMatchId(Long matchId) {
		Room room = roomRepository.findByMatchId(matchId)
			.orElseThrow(() -> new IllegalArgumentException(MISMATCH_MATCH_ID_ERROR_MESSAGE));
		return new RoomResponse(room);
	}

	public void createRoom(RoomCreateRequest roomCreateRequest) {
		roomRepository.save(Room.from(roomCreateRequest));
	}

	public void modifyRoom(RoomModifyRequest modifyRequest) {
		Room room = roomRepository.findById(modifyRequest.getId())
			.orElseThrow(() -> new IllegalArgumentException(MODIFY_ROOM_ERROR_MESSAGE));
		room.update(modifyRequest);
	}
}
